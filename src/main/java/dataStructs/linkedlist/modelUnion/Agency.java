package dataStructs.linkedlist.modelUnion;

import utils.Node;

public class Agency {
    private String name;
    Node<Model> models;

    public Agency(String name, Node<Model> models) {
        this.name = name;
        this.models = models;
    }

    public boolean hasModel(String id) {
        Node<Model> ptr = this.models;
        while (ptr != null) {
            if (ptr.getValue().getId().equals(id)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node<Model> getModels() {
        return models;
    }

    public void setModels(Node<Model> models) {
        this.models = models;
    }

}
