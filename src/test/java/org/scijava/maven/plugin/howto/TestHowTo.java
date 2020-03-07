package org.scijava.maven.plugin.howto;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.TypeDeclaration;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestHowTo {

	@Test
	public void replaceStrings() throws ParserConfigurationException, SAXException, IOException {
		BuildHowToMojo mojo = new BuildHowToMojo();
		String resourceLink = mojo.replaceLinks("<li>My resource: {@link /src/test/resources/test.xml}</li>");
		assertEquals("<li>My resource: <div class=\"resource\"><pre><code><test></test></code></pre></div></li>", resourceLink);
	}

	@Test
	public void findHowTos() throws IOException {

		File testsource = new File("src/test/java/org/scijava/maven/plugin/howto/TestHowTo.java");
		CompilationUnit compilationUnit = StaticJavaParser.parse(testsource.getAbsolutePath());
		NodeList<TypeDeclaration<?>> types = compilationUnit.getTypes();
		System.out.println(types);
	}

}
