package pl.put.poznan.transformer.logic;

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
        // of course normally it would to something based on transforms
        return text.toUpperCase();
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
