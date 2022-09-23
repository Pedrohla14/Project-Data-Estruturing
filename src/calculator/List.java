package calculator;

public class List<ObjectType> {
	private Element<ObjectType> first;
	private Element<ObjectType> last;
	
    private int size;
    
    public List(){
        this.size = 0;
    }

    public Element<ObjectType> getFirst() {
        return first;
    }

    public void setFirst(Element<ObjectType> first) {
        this.first = first;
    }

    public Element<ObjectType> getLast() {
        return last;
    }

    public void setLast(Element<ObjectType> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void add(ObjectType currentValue){
        Element<ObjectType> newElement = new Element<ObjectType>(currentValue);
        if (this.first == null && this.last == null){
            this.first = newElement;
            this.last = newElement;            
        }else{
            this.last.setNextValue(newElement);
            this.last = newElement;            
        }
        this.size++;
    }

    public void removeByIndex(int index) {
    	Element<ObjectType> prev = null;
    	Element<ObjectType> current = this.first;
    	
    	for(int i = 0; i < this.getSize(); i++) {
    		if(index == i) {
    			if(this.size == 1) {
    				this.first = null;
    				this.last = null;
    			}
    			else if (current.equals(first)){
    				this.first = current.getNextValue();
    				current.setNextValue(null);
    			}
    			else if (current.equals(last)){
                    this.last = prev;
                    prev.setNextValue(null);
                }else{
                    prev.setNextValue(current.getNextValue());
                    current = null;
                }
                this.size--;
                break;
    		}
    		prev = current;
    		current = current.getNextValue();
    	}
    }
    
    public Element<ObjectType> get(int position){
    	Element<ObjectType> current = this.first;
        for(int i=0; i < position; i++){
            if (current.getNextValue() != null){
                current = current.getNextValue();
            }
        }
        return current;
    }
}
