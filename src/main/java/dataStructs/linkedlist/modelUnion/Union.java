package dataStructs.linkedlist.modelUnion;

import static utils.LinkedListUtils.contains;

import utils.Node;

public class Union {
    public static final int N = 2;
    private Agency[] agencies = new Agency[N];

    public Union(Agency[] agencies) {
        this.agencies = agencies;
    }

    public Agency[] getAgencies() {
        return agencies;
    }

    public void setAgencies(Agency[] agencies) {
        this.agencies = agencies;
    }

    public Node<String> getPhotographyModelIds() {
        Node<String> ids = new Node<String>(null);
        Node<String> ptrid = ids;
        for (var agency : this.agencies) {
            Node<Model> ptr = agency.getModels();
            while (ptr != null) {
                if (ptr.getValue().getExpertise().equals("photography")) {
                    if (!contains(ids.getNext(), ptr.getValue().getId())) {
                        ptrid.setNext(new Node<>(ptr.getValue().getId()));
                        ptrid = ptrid.getNext();
                    }
                }
                ptr = ptr.getNext();
            }
        }

        return ids.getNext();
    }

    public void printAgencysOfModel(String id) {
        for (var agency : this.agencies) {
            if (agency.hasModel(id)) {
                System.out.println(agency.getName());
            }
        }
    }

    public void removeOldModels() {
        for (var agency : this.agencies) {
            Node<Model> ptr = agency.getModels();
            while (ptr.hasNext()) {
                if (Integer.parseInt(ptr.getNext().getValue().getBirthYear()) <= 1980) {
                    System.out.println("Removed model " + ptr.getNext().getValue().getName() + " from agency "
                            + agency.getName());
                    ptr.setNext(ptr.getNext().getNext());
                } else {
                    ptr = ptr.getNext();
                }
            }

            if (Integer.parseInt(agency.getModels().getValue().getBirthYear()) <= 1980) {
                System.out.println("Removed model " + ptr.getValue().getName() + " from agency "
                        + agency.getName());
                agency.setModels(agency.getModels().getNext());
            }
        }
    }

    public void addModel(Model model, String agencyName) {
        for (var agency : this.agencies) {
            if (agency.getName().equals(agencyName)) {
                agency.setModels(new Node<Model>(model, agency.getModels()));
                return;
            }
        }
    }
}
