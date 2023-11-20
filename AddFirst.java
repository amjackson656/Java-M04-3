// BEGIN REVEL SUBMISSION

// Add an element to the beginning of the list 
public void addFirst(E e) {
    Node<E> newNode = new Node<>(e);
    newNode.next = head;
    if (head != null) {
        head.previous = newNode;
    }
    head = newNode;
    if (tail == null) {
        tail = head;
    }
    size++;
}

// Add an element to the end of the list 
public void addLast(E e) {
    Node<E> newNode = new Node<>(e);
    if (tail == null) {
        head = tail = newNode;
    } else {
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }
    size++;
}

// Add a new element at the specified index in this list 
public void add(int index, E e) {
    if (index == 0) {
        addFirst(e);
    } else if (index >= size) {
        addLast(e);
    } else {
        Node<E> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        Node<E> temp = current.next;
        current.next = new Node<>(e);
        (current.next).next = temp;
        (current.next).previous = current;
        if (temp != null) {
            temp.previous = current.next;
        }
        size++;
    }
}

// Remove the head node and return the object that is contained in the removed node. 
public E removeFirst() {
    if (size == 0) return null;
    else {
        Node<E> temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.previous = null;
        }
        size--;
        return temp.element;
    }
}

// Remove the last node and return the object that is contained in the removed node. 
public E removeLast() {
    if (size == 0) return null;
    else if (size == 1) {
        Node<E> temp = head;
        head = tail = null;
        size = 0;
        return temp.element;
    } else {
        Node<E> temp = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return temp.element;
    }
}

// Remove the element at the specified position in this list. Return the element that was removed from the list. 
public E remove(int index) {
    if (index < 0 || index >= size) return null;
    else if (index == 0) return removeFirst();
    else if (index == size - 1) return removeLast();
    else {
        Node<E> previous = head;

        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }

        Node<E> current = previous.next;
        previous.next = current.next;
        if (current.next != null) {
            current.next.previous = previous;
        }
        size--;
        return current.element;
    }
}

// END REVEL SUBMISSION
