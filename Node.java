package com.example;

public class Node<type> {
    public Node<type> right,left,next;
    public type data;
    public Node (type data){
        this.data = data;
        this.right =this.left= null;
    }
    public Node(){
        
    }
    
}
