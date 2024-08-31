// Copyright (c) 2020, alex@justprodev.com.
// All rights reserved. Use of this source code is governed by a
// MIT License that can be found in the LICENSE file.

package com.justprodev.json_to_freezed.generator

import com.justprodev.json_to_freezed.utils.createFileName

/**
 * Model's className & fileName
 */
class ModelName(val className: String, val fileName: String) {
    companion object {
        fun fromClassName(className: String) = ModelName(className, createFileName(className))
    }
}