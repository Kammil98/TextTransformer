package pl.put.poznan.transformer.logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class InverseTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new Inverse(t);
		assertEquals("ikar łapał rakI",t.transform_text("Ikar łapał raki"));
	}

}
