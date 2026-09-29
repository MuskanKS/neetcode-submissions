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
        // optimal
        // without using hashmap
        if(head == null){
            return null;
        }

        HashMap<Node, Node> hm = new HashMap<>();

        Node curr = head;

        // insert copied nodes inside original
        // here its just that we will move the pointer and will keep on changing to store a copy of same element  
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;

        }

        curr = head;
        // reset it back to head and here we have new list with copies 
        // then we will check for random and as we know if we want to store random for copy we cant do curr.random because that will just store the O4 like that and we want C4 copy of it so we know after original we have copy so we will do curr.random.next
        while(curr != null){
            Node copy = curr.next;
            if(curr.random != null){
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }
        curr = head;
        //reset  curr and make head of copy also as curr.next as we know it already why
        Node copyHead = head.next;

        while(curr != null){
            // then when move inside we store the copy in the copy node and then change its next pointer means the O1 previously pointing at C1 now we changed its next to O2 then we go inside another loop to check if the C1 have more loops connected if so we will skip one and connect it to anaother because c1 is connected to c2 when we break it we get c1-> c2 after that then when we move forward we see o2 and c1 are now both connect so new curr will become o2 as its next to o1 and same continues until nothing is left
            Node copy = curr.next;
            curr.next = copy.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return copyHead;
    }
}
