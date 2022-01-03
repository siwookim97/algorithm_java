package Chapter04;

public class DoubleIntStack {
    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    // 실행 시 예외 : 스택이 비어있음;
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    // 생성자
    public DoubleIntStack(int capacity) {
        ptrA = 0;
        max = capacity;
        ptrB = max - 1;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // A스택에 x 푸쉬
    public int pushA(int x) throws IntStack.OverflowIntStackException {
        if (max - 1 - ptrB + ptrA >= max) {
            throw new DoubleIntStack.OverflowIntStackException();
        }
        return stk[ptrA++] = x;
    }

    // B스택에 x 푸쉬
    public int pushB(int x) throws IntStack.OverflowIntStackException {
        if (max - 1 - ptrB + ptrA >= max) {
            throw new DoubleIntStack.OverflowIntStackException();
        }
        return stk[ptrB--] = x;
    }

    // 스택에서 x 팝
    public int popA() throws IntStack.EmptyIntStackException {
        if (ptrA <= 0) {
            throw new DoubleIntStack.EmptyIntStackException();
        }
        return stk[--ptrA];
    }

    // B스택에서 x 팝
    public int popB() throws IntStack.EmptyIntStackException {
        if (ptrB >= max) {
            throw new DoubleIntStack.EmptyIntStackException();
        }
        return stk[++ptrB];
    }

    // A스택에서 데이터를 피크
    public int peekA() throws IntStack.EmptyIntStackException {
        if (ptrA <= 0)
            throw new DoubleIntStack.EmptyIntStackException();
        return stk[ptrA - 1];
    }

    // B스택에서 데이터를 피크
    public int peekB() throws IntStack.EmptyIntStackException {
        if (ptrB >= max)
            throw new DoubleIntStack.EmptyIntStackException();
        return stk[ptrB + 1];
    }

    // A스택에서 x를 찾아 인덱스를 반환
    public int indexOfA(int x) {
        for (int i = ptrA - 1; i >= 0; i--) {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    // B스택에서 x를 찾아 인덱스를 반환
    public int indexOfB(int x) {
        for (int i = ptrB + 1; i >= max; i++) {
            if (stk[i] == x)
                return i;
        }
        return -1;
    }

    // A스택을 비움
    public void clearA() {
        ptrA = 0;
    }

    public void clearB() {
        ptrB = 0;
    }

    // 스택 max 용량을 보여줌
    public int capacity() {
        return max;
    }

    // A스택에 쌓인 데이터 수를 반환
    public int sizeA() {
        return ptrA;
    }

    public int sizeB() {
        return max - 1 - ptrB;
    }

    // A스택이 비어있는가?
    public boolean isEmptyA() {
        return ptrA <= 0;
    }

    public boolean isEmptyB() {
        return ptrB >= max;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return max - 1 - ptrB + ptrA >= max;
    }

    // 스택 안의 모든 데이터를 바닥에서 꼭대기로 출력
    public void dumpA() {
        if (ptrA <= 0)
            System.out.println("A스택이 비었습니다.");
        else {
            for (int i = 0; i < ptrA; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

    public void dumpB() {
        if(ptrB >= max)
            System.out.println("B스택이 비었습니다.");
        else {
            for (int i = max - 1; i > ptrB; i--) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
