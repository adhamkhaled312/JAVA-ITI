<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Notes Summary</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>from</th>
                        <th>to</th>
                        <th>body</th>
                    </tr>
                    <xsl:for-each select="//note">
                        <xsl:sort select="from"/>
                            <tr>
                                <td>
                                    <xsl:value-of select="from"/>
                                </td>
                                <td>
                                    <xsl:value-of select="to"/>
                                </td>
                                <td>
                                    <xsl:value-of select="body"/>
                                </td>
                            </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
