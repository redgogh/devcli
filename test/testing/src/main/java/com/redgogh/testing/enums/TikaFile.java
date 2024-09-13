package com.redgogh.testing.enums;

/* -------------------------------------------------------------------------------- *\
|*                                                                                  *|
|*    Copyright (C) 2023 RedGogh                                                    *|
|*                                                                                  *|
|*    This program is free software: you can redistribute it and/or modify          *|
|*    it under the terms of the GNU General Public License as published by          *|
|*    the Free Software Foundation, either version 3 of the License, or             *|
|*    (at your option) any later version.                                           *|
|*                                                                                  *|
|*    This program is distributed in the hope that it will be useful,               *|
|*    but WITHOUT ANY WARRANTY; without even the implied warranty of                *|
|*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                 *|
|*    GNU General Public License for more details.                                  *|
|*                                                                                  *|
|*    You should have received a copy of the GNU General Public License             *|
|*    along with this program.  If not, see <https://www.gnu.org/licenses/>.        *|
|*                                                                                  *|
|*    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.    *|
|*    This is free software, and you are welcome to redistribute it                 *|
|*    under certain conditions; type `show c' for details.                          *|
|*                                                                                  *|
\* -------------------------------------------------------------------------------- */

/* Create on 2024/9/13 */

import org.apache.tika.Tika;

import java.io.InputStream;

import static com.redgogh.tools.Assert.throwIfError;

/**
 * `TikaFile` 枚举定义了常见的文件类型，用于表示不同的文件格式。
 *
 * <p>该枚举类包括各种文件格式的标识符，便于在处理文件时进行格式分类和操作。它适用于文件上传、解析、处理等场景。
 *
 * <h2>枚举常量</h2>
 * <ul>
 *     <li>{@link #PDF} - 代表 PDF 文件格式。</li>
 *     <li>{@link #DOC} - 代表旧版 Microsoft Word 文档格式。</li>
 *     <li>{@link #DOCX} - 代表新版 Microsoft Word 文档格式（基于 XML）。</li>
 *     <li>{@link #PPT} - 代表旧版 Microsoft PowerPoint 演示文稿格式。</li>
 *     <li>{@link #PPTX} - 代表新版 Microsoft PowerPoint 演示文稿格式（基于 XML）。</li>
 *     <li>{@link #XLS} - 代表旧版 Microsoft Excel 工作簿格式。</li>
 *     <li>{@link #XLSX} - 代表新版 Microsoft Excel 工作簿格式（基于 XML）。</li>
 * </ul>
 *
 * <h2>使用示例</h2>
 * <pre>
 *     // 获取文件类型
 *     TikaFile fileType = TikaFile.PDF;
 *
 *     // 根据文件类型执行操作
 *     switch (fileType) {
 *         case PDF:
 *             // 处理 PDF 文件
 *             break;
 *         case DOCX:
 *             // 处理 DOCX 文件
 *             break;
 *         // 其他文件类型
 *     }
 * </pre>
 *
 * @author RedGogh
 * @since 1.0
 */
public enum TikaFile {

    /** 代表 PDF 文件格式 */
    PDF,

    /** 代表旧版 Microsoft Word 文档格式 */
    DOC,

    /** 代表新版 Microsoft Word 文档格式（基于 XML） */
    DOCX,

    /** 代表旧版 Microsoft PowerPoint 演示文稿格式 */
    PPT,

    /** 代表新版 Microsoft PowerPoint 演示文稿格式（基于 XML） */
    PPTX,

    /** 代表旧版 Microsoft Excel 工作簿格式 */
    XLS,

    /** 代表新版 Microsoft Excel 工作簿格式（基于 XML） */
    XLSX,

    /** 代表普通文本文件格式 */
    TEXT,
    ;

    /**
     * Tika 实例
     */
    private static final Tika tika = new Tika();

    /**
     * 任意文档数据流转文本
     */
    public static String readText(InputStream stream) {
        return throwIfError(() -> tika.parseToString(stream));
    }

}
