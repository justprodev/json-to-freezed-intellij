// Copyright (c) 2020, alex@justprodev.com.
// All rights reserved. Use of this source code is governed by a
// MIT License that can be found in the LICENSE file.

package com.justprodev.json_to_freezed.utils

import com.google.gson.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Container for JSON element
 *
 * Used for validating and prettifying JSON
 *
 * The flow is:
 *
 * 1. Validate JSON
 * 2. Prettify JSON
  */
class JsonContainer {
    private var validateJob: Job? = null
    private val mutex = Mutex()
    private val gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()

    var element: JsonElement? = null
        private set

    /**
     * Validate JSON
     *
     * `element` will be updated with parsed JSON
     *
     * @param json JSON string
     * @param result invoked when validation is done
     */
    fun validate(json: String, result: (JsonElement?) -> Unit) {
        if (mutex.isLocked) return

        validateJob?.cancel()
        validateJob = GlobalScope.launch(Dispatchers.IO) {
            val element = try {
                val parsed = JsonParser.parseString(json)

                if (parsed.isJsonObject || parsed.isJsonArray) {
                    parsed
                } else {
                    null
                }
            } catch (e: Throwable) {
                null
            }

            this@JsonContainer.element = element

            result(element)
        }
    }

    /**
     * Prettify JSON from `element`
     *
     * @param result invoked when prettifying is done
     */
    fun prettify(result: (String) -> Unit) {
        val element = element ?: return

        validateJob?.invokeOnCompletion {
            GlobalScope.launch(Dispatchers.IO) {
                mutex.withLock {
                    val `object` = if (element.isJsonObject) {
                        element.asJsonObject
                    } else {
                        element.asJsonArray
                    }
                    val prettyJson = gson.toJson(`object`)
                    result(prettyJson)
                }
            }
        }
    }
}