package pl.put.poznan.transformer.logic;

abstract class TextTransformerDecorator implements TransformInterface {
	public String transform_object;
	private TransformInterface core;
	
	public TextTransformerDecorator(TransformInterface inner) {
        setCore(inner);
    }

    public String transform_text(String transform_object) {
        getCore().transform_text(transform_object);
        return transform_object;
    }

	public TransformInterface getCore() {
		return core;
	}

	public void setCore(TransformInterface core) {
		this.core = core;
	}
}
