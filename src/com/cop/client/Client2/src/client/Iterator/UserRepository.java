/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.Iterator;

/**
 *
 * @author Carlos Guisao
 */
public class UserRepository implements Container {
    
    public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};
    
    @Override
    public Iterator getIterator() {
        return new UserIterator();
    }
    
    private class UserIterator implements Iterator {
        
        int index;

        @Override
        public boolean hasNext() {

           if(index < names.length){
              return true;
           }
           return false;
        }

        @Override
        public Object next() {

           if(this.hasNext()){
              return names[index++];
           }
           return null;
        }		
    }
}
