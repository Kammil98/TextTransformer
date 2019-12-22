package pl.put.poznan.transformer.logic;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class TextTransformerTest {

	@Test
	public void test() {
		TextTransformer t=new TextTransformer();
		t.setTextToChange("ola ola");
		String[] transformacje = {"delete","upper"};
		t.setTransforms(transformacje);
		assertEquals("OLA",t.transform("ola ola"));	
		
	}

}
