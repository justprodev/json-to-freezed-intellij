// Copyright (c) 2020, alex@justprodev.com.
// All rights reserved. Use of this source code is governed by a
// MIT License that can be found in the LICENSE file.

package com.justprodev.dart_json_generator.utils

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import java.io.IOException

fun VirtualFile.write(project: Project?, content: String) {
    val runnable = Runnable {
        try {
            setBinaryContent(content.toByteArray())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    WriteCommandAction.runWriteCommandAction(project, runnable)
}