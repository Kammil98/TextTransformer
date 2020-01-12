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
    	boolean transoformable = true;
    	for(String operation: transforms) {
    		transoformable = true;
    		switch(operation) {
    		case "inverse":
    			t=new Inverse(t);
        		break;
    		case "delete":
    			t=new DeleteRepetition(t);
        		break;
    		case "capitalize":
    			t=new Capitalize(t);
        		break;
    		case "lower":
    			t=new ToLower(t);
        		break;
    		case "upper":
    			t=new ToUpper(t);
        		break;
    		case "numbers":
    			t=new NumberToText(t);
    			break;
    		case "shorten":
    			t=new Shorten(t);
    			break;
    		case "lengthen":
    			t=new Lengthen(t);
    			break;
        	default :
        		transoformable = false;
    		}
    		/*if(transoformable)
    			text=t.transform_text(text); */
    	}
    	text=t.transform_text(text); 
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
