package calculator;

public class Element <ObjectType> {
    private ObjectType value;
    private Element <ObjectType> nextValue;
    
    public Element(ObjectType newValue){
        this.value = newValue;
    }

    public ObjectType getValue() {
        return value;
    }

    public void setValue(ObjectType value) {
        this.value = value;
    }

    public Element<ObjectType> getNextValue() {
        return nextValue;
    }

    public void setNextValue(Element<ObjectType> nextValue) {
        this.nextValue = nextValue;
    }
}
