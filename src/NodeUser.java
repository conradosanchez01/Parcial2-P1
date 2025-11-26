

// porque sino repetiria la clase
class NodeUser {
    String user;
    NodeUser next;

    public NodeUser(String user) {
        this.user = user;
        this.next = null;
    }
}

class QueueUsers {
    private NodeUser front;
    private NodeUser rear;

    public QueueUsers() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String user) {
        NodeUser nuevo = new NodeUser(user);
        if (rear == null) {
            front = rear = nuevo;
        } else {
            rear.next = nuevo;
            rear = nuevo;
        }
    }

    public String dequeue() {
        if (isEmpty()) return null;
        String user = front.user;
        front = front.next;
        if (front == null) rear = null;
        return user;
    }

    public String peek() {
        if (isEmpty()) return null;
        return front.user;
    }
}
