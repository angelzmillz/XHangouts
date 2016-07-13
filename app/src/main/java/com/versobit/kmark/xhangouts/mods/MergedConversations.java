/*
 * Copyright (C) 2015-2016 Kevin Mark
 *
 * This file is part of XHangouts.
 *
 * XHangouts is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XHangouts is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with XHangouts.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.versobit.kmark.xhangouts.mods;

import android.content.Context;

import com.versobit.kmark.xhangouts.Config;

import de.robv.android.xposed.XC_MethodReplacement;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

public class MergedConversations {

    // This might stop working in Hangouts v12+
    private static final String HANGOUTS_MERGED_CONVERSATION = "feg";
    private static final String HANGOUTS_MERGED_CONVERSATION_PARAM = "kaq";

    public static void handleLoadPackage(final Config config, ClassLoader loader) {
        if (!config.modEnabled) {
            return;
        }

        Class cMergedConversation = findClass(HANGOUTS_MERGED_CONVERSATION, loader);
        Class cParam = findClass(HANGOUTS_MERGED_CONVERSATION_PARAM, loader);

        findAndHookMethod(cMergedConversation, "a", Context.class, cParam, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return null;
            }
        });
        findAndHookMethod(cMergedConversation, "a", cParam, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return null;
            }
        });
        findAndHookMethod(cMergedConversation, "b", Context.class, cParam, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return null;
            }
        });

    }
}
