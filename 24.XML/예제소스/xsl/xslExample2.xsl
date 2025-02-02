<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
	              xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="utf-8" />
    
    <!-- 시작 템플레이트 룰 -->
	<xsl:template match="/">
		<html>
			<body>
				<h2><font color="blue">Computer 도서 목록</font></h2>
				<table border="1" cellspacing="0" width="70%">
					<tr bgcolor="#FFFF66">
						<th>title</th>
						<th>author</th>
						<th>publisher</th>
						<th>price</th>
					</tr>

					<!-- book 템플레이트 룰 적용 -->
					<xsl:apply-templates select="/booklist/book[@kind='computer']"/>

				</table>
				
				<br/><hr align="left" width="80%"/>

				<!-- name 속성을 갖는 템플레이트 룰 적용 -->
				<xsl:call-template name="company"/>

			</body>
		</html>
	</xsl:template>

	<!-- book 템플레이트 룰 -->
	<xsl:template match="book">
		<tr>
			<td><xsl:value-of select="title"/></td>
			<td><xsl:value-of select="author"/></td>
			<td><xsl:value-of select="publisher" /></td>
			<td><xsl:value-of select="price" /></td>
		</tr>
	</xsl:template>

	<!-- name 속성을 갖는 템플레이트 룰 -->
	<xsl:template name="company">
		<font color="blue">ABC 소프트웨어</font> 주식회사 - 서울시 역삼동
	</xsl:template>

</xsl:stylesheet>
