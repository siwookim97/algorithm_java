package Chapter04;

import java.nio.channels.OverlappingFileLockException;

public class IntStack {
    private int max;
    private int ptr;
    private int[] stk;

    // 실행 시 예외 : 스택이 비어있음;
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {};
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {};
    }

    // 생성자
    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 스택에 x 푸쉬
    public int push(int x) throws OverflowIntStackException {
        if(ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    // 스택에서 x 팝
    public int pop() throws EmptyIntStackException {
        if(ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크
    public int peek() throws EmptyIntStackException {
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    //스택에서 x를 찾아 인덱스를 반환
    public int indexOf(int x) {
        for(int i = ptr - 1; i >= 0; i--) {
            if(stk[i] == x)
                return i;
        }
        return -1;
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }

    // max 용량을 보여줌
    public int capacity() {
        return max;
    }

    // 스택에 쌓인 데이터 수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= max;
    }
    
    // 스택 안의 모든 데이터를 바닥에서 꼭대기로 출력
    public void dump() {
        if(ptr <= 0)
            System.out.println("스택이 비었습니다.");
        else {
            for(int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }
}
