package Chapter07;

public class IntSortedSet {
    private int max;
    private int num;
    private int[] set;

    public void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    public IntSortedSet(int capacity) {
        max = capacity;
        num = 0;
        try {
            set = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public int indexOf(int n) {
        for (int i = 0; i < num; i++)
            if (set[i] == n)
                return i;
        return -1;
    }

    public boolean contains(int n) {
        return (indexOf(n) != -1) ? true : false;
    }

    public boolean add(int n) {

        if (num >= max || contains(n) == true)
            return false;
        else {
            set[num++] = n;

            int k = 0;  // 버블 정렬을 통해서 집합을 정렬
            while (k < num - 1) {
                int last = num - 1;
                for (int j = num - 1; j > k; j--)
                    if (set[j - 1] > set[j]) {
                        swap(set, j - 1, j);
                        last = j;
                    }
                k = last;
            }

            return true;
        }
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            for (int i = idx; i < num - 1; i++) {
                set[i] = set[i + 1];
            }
            num--;
            return true;
        }
    }

    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i = 0; i < num; i++)
            temp.append(set[i] + "  ");
        temp.append("}");
        return temp.toString();
    }
}
