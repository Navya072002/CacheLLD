package Cache.CacheLLD.Templates;

import Cache.CacheLLD.Templates.Exceptions.element_ex;
import lombok.Getter;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    DoublyLinkedListNode<E> dummy_head;
    DoublyLinkedListNode<E> dummy_tail;

    public DoublyLinkedList() {
        dummy_head = new DoublyLinkedListNode<>(null);
        dummy_tail = new DoublyLinkedListNode<>(null);

        dummy_head.next = dummy_tail;
        dummy_tail.prev = dummy_head;
    }

    public void detachNode(DoublyLinkedListNode<E> node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void addNodeAtLast(DoublyLinkedListNode<E> node) {
        DoublyLinkedListNode tailPrev = dummy_tail.prev;
        tailPrev.next = node;
        node.next = dummy_tail;
        dummy_tail.prev = node;
        node.prev = tailPrev;
    }

    public DoublyLinkedListNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> newNode = new DoublyLinkedListNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public boolean isItemPresent() {
        return dummy_head.next != dummy_tail;
    }

    public DoublyLinkedListNode getFirstNode() throws NoSuchElementException {
        DoublyLinkedListNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummy_head.next;
    }

    public DoublyLinkedListNode getLastNode() throws NoSuchElementException {
        DoublyLinkedListNode item = null;
        if (!isItemPresent()) {
            return null;
        }
        return dummy_tail.prev;
    }
}