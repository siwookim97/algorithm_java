package Chapter07;

public class IntSet {
    private int max;
    private int num;
    private int[] set;

    public IntSet(int capacity) {
        num = 0;
        max = capacity;
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
            return true;
        }
    }

    public boolean add(IntSet s) { // 합집합
        boolean flag = false;
        for (int i = 0; i < s.num; i++) {
            if (add(s.set[i]) == true)
                flag = true;
        }
        return flag;
    }

    public boolean retain(IntSet s) { // 교집합
        boolean flag = false;
        IntSet temp = new IntSet(max);
        int n = 0;

        for (int i = 0; i < s.num; i++) {
            if (contains(s.set[i]) == true) {
                temp.add(s.set[i]);
                n++;
                flag = true;
            }
        }
        if (n != 0) {
            for (int i = 0; i < n; i++)
                set[i] = temp.set[i];
        }
        num = n;

        return flag;
    }

    public boolean retain_ver2(IntSet s) { // 교집합 ver.2, 더욱 간단함
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (s.contains(set[i]) == false) {
                remove(set[i]);
                flag = true;
            }
        return flag;

    }

    public boolean remove(IntSet s) { // 차집합
        boolean flag = false;
        for (int i = 0; i < s.num; i++) {
            if (contains(s.set[i]) == true) {
                remove(s.set[i]);
                flag = true;
            }
        }
        return flag;
    }

    public boolean remove(int n) {
        int idx;

        if (num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else {
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = (s.max < num) ? s.max : num;
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num;
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;

    }

    public boolean equalTo(IntSet s) {
        if (num != s.num)
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j])
                    break;
            if (j == s.num)
                return false;

        }
        return true;

    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);

    }

    public String toString() {
        StringBuffer temp = new StringBuffer("{");
        for(int i = 0; i < num; i++)
            temp.append(set[i]+" ");
        temp.append("}");
        return temp.toString();
    }

    public boolean isEmpty() {
        return num == 0;

    }

    public boolean isFull() {
        return num >= max;
    }

    public void clear() {
        num = 0;
    }

    public boolean isSubsetOf(IntSet s) { // s의 부분집합인지 확인하는 메서드
        if (num > s.num) // s보다 요소가 더 있다면 부분집합이 될 수 없다
            return false;

        for (int i = 0; i < num; i++) {
            int j = 0;
            for ( ; j < s.num; j++) {
                if (set[i] == s.set[j])
                    break;
            }
            if (j == s.num)
                return false;
        }
        return true;
    }


    public boolean isProperSubsetOf(IntSet s) {
        if (num >= s.num)
            return false;

        return isSubsetOf(s);
    }

    public void intersectionOf(IntSet s1, IntSet s2) {
        clear();
        for (int i = 0; i < s1.num; i++)
            if (s2.contains(s1.set[i]) == true)
                add(s1.set[i]);
    }

    public void differenceOf(IntSet s1, IntSet s2) {
        clear();
        for (int i = 0; i < s1.num; i++)
            if (s2.contains(s1.set[i]) != true)
                add(s1.set[i]);
    }
}
