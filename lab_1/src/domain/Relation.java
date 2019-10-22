package domain;

public class Relation<KeyType> {
    public KeyType keyA;
    public KeyType keyB;

    public Relation(KeyType keyA, KeyType keyB) {
        this.keyA = keyA;
        this.keyB = keyB;
    }

    public KeyType getKeyA() {
        return keyA;
    }

    public void setKeyA(KeyType keyA) {
        this.keyA = keyA;
    }

    public KeyType getKeyB() {
        return keyB;
    }

    public void setKeyB(KeyType keyB) {
        this.keyB = keyB;
    }
}

//{
//
//    private ArrayList<KeyType> firstColumn = new ArrayList<KeyType>();
//    private ArrayList<KeyType> secondColumn = new ArrayList<KeyType>();
//
//    public void addRelation(KeyType keyA, KeyType keyB) {
//        firstColumn.add(keyA);
//        secondColumn.add(keyB);
//    }
//
//    public void removeRelation(int index) {
//        firstColumn.remove(index);
//        secondColumn.remove(index);
//    }
//
//    public boolean existsRelation(KeyType keyA, KeyType keyB) {
//        for (int i = 0; i < firstColumn.size(); i++) {
//            if (firstColumn.get(i) == keyA && secondColumn.get(i) == keyB) {
//                return true;
//            } else if (firstColumn.get(i) == keyB && secondColumn.get(i) == keyA) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//}
