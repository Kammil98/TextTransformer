package pl.put.poznan.transformer.logic;
import java.util.Arrays; 

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

	private String textToChange;
    private String[] transforms;
    public TextTransformer(){
    }
    public TextTransformer(String[] transforms){
        this.setTransforms(transforms);
    }

    public String transform(String text){
    	TransformInterface t = new TextTransformerDecoratorHelper();
    	
    	if(Arrays.asList(this.transforms).contains("inverse")) {
    		t=new Inverse(t);
    		text=t.transform_text(text); 
    	}
    	
    	if(Arrays.asList(this.transforms).contains("delete")) {
    		t=new DeleteRepetition(t);
    		text=t.transform_text(text); 
    	}
    	
    	if(Arrays.asList(this.transforms).contains("capitalize")) {
    		t=new Capitalize(t);
    		text=t.transform_text(text); 
    	}
    	
    	if(Arrays.asList(this.transforms).contains("lower")) {
    		t=new ToLower(t);
    		text=t.transform_text(text); 
    	}
    	
    	if(Arrays.asList(this.transforms).contains("upper")) {
    		t=new ToUpper(t);
    		text=t.transform_text(text); 
    	}
       //System.out.println(text);
    	this.textToChange=text;
        return text;
    }

	public String[] getTransforms() {
		return transforms;
	}

	public void setTransforms(String[] transforms) {
		this.transforms = transforms;
	}
	public String getTextToChange() {
		return textToChange;
	}
	public void setTextToChange(String textToChange) {
		this.textToChange = textToChange;
	}
}
