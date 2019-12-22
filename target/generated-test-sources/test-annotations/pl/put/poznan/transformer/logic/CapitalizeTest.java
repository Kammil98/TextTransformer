package pl.put.poznan.transformer.logic;
import static org.junit.Assert.*;

import org.junit.Test;

import pl.put.poznan.transformer.logic.Capitalize;
import pl.put.poznan.transformer.logic.TextTransformerDecoratorHelper;
import pl.put.poznan.transformer.logic.TransformInterface;

public class CapitalizeTest {

	@Test
	public void test() {
		TransformInterface t = new TextTransformerDecoratorHelper();
		t=new Capitalize(t);
		assertEquals("Ola",t.transform_text("ola"));	
	}

}
