package LinkedList;

import java.util.Arrays;

public class LinkedList {
     class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size=1;
            return;
        }
        newNode.next=head;
        head=newNode;
        size++;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            size=1;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LL is Empty");
            return -1;
        }
        else if(size==1){
            int val=head.data;
            size=0;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("LL is Empty");
            return -1;
        }
        else if(size==1){
            int val=head.data;
            size=0;
            head=tail=null;
            return val;
        }
        int i=0;
        Node temp=head;
        while(i<size-2){
            temp=temp.next;
            i++;
        }
        int val=tail.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int itSearch(int ele){
        Node temp=head;
        if(temp==null){
            System.out.println("LL is Empty");
            return -1;
        }
        int i=0;
        while(temp!=null){
            if(temp.data==ele){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void reverseLL(Node head){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void printLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");

    }
    public void findAndDelete(int ele){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            if(curr.data==ele){
                prev.next=curr.next;
                curr.next=null;
                return;
            }
            prev=curr;
            curr=curr.next;
        }
    }
    public void findAndDeleteNthFromEnd(int n){
        int listSize=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            listSize++;
        }
        if(listSize==n){
            head=head.next;
            return;
        }
        Node prev=null;
        Node curr=head;

        for(int i=0;i<listSize-n;i++){
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
    }
    public Node findMid(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);

        System.out.println(ll.findMid().data);


    }
}
