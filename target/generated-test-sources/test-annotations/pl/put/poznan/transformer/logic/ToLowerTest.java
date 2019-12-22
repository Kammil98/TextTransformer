package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToLowerTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new ToLower(t);
		assertEquals("mama",t.transform_text("MaMA"));
	}

}
