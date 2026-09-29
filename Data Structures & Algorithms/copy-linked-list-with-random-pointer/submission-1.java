/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // brute
        if(head == null){
            return null;
        }

        List<Node> original = new  ArrayList<>();
        List<Node> copy = new ArrayList<>();

        Node curr = head;

        while(curr != null){
            original.add(curr);
            copy.add(new Node(curr.val));
            curr = curr.next;
        }
        // connect nect pointer
        for(int i = 0; i < copy.size() - 1; i++){
            copy.get(i).next = copy.get(i+1);
        }
        // connect random pointer
        for(int i = 0; i < original.size(); i++){
            Node randomNode = original.get(i).random;

            if(randomNode != null){
                int j = 0;
                while(original.get(j) != randomNode){
                    j++;
                }
                copy.get(i).random = copy.get(j);
            }
        }return copy.get(0);
    }
}
