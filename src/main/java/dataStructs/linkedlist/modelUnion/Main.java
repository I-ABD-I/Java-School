package dataStructs.linkedlist.modelUnion;

import static utils.LinkedListUtils.build;

public class Main {

    public static void modelMain() {
        Agency[] agencies = new Agency[Union.N];

        agencies[0] = new Agency("Agency 1",
                build(new Model("Model 1", "0001", "1990", "photography"),
                        new Model("Model 2", "0002", "1978", "photography"),
                        new Model("Model 3", "0003", "2000", "a")));

        agencies[1] = new Agency("Agency 2",
                build(new Model("Model 4", "0004", "1966", "b"),
                        new Model("Model 5", "0005", "2004", "c"),
                        new Model("Model 2", "0002", "1978", "photography")));

        Union union = new Union(agencies);
        System.out.println(union.getPhotographyModelIds());
        union.printAgencysOfModel("0002");
        union.removeOldModels();
        union.addModel(new Model("Model 6", "0006", "2020", "a"), "Agency 1");
    }

}
