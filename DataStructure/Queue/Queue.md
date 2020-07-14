# 큐(Queue)

### 특징

- **먼저 들어온 데이터가 먼저 나가는 구조**
  - 예) 서비스 대기 행렬
- `선입선출(FIFO: First-In First-Out)`
  - 가장 먼저 삽입(First In)된 원소는 가장 먼저 삭제(First Out)됨
  - 큐는 **뒤(rear)에서 새로운 데이터가 추가**되고 **앞(front)에서 데이터가 하나씩 삭제**되는 구조
  - `스택`의 경우 삽입과 삭제가 같은 쪽에서 일어나지만, `큐`에서는 삽입과 삭제가 다른 쪽에서 일어남
    - 스택에서는 삽입, 삭제와 관련하여 **top**이라 불리는 변수가 1개만 존재하는 데 비해 큐에서는 **삽입과 관련된 변수 rear**와 **삭제와 관련된 변수 front** 2개가 존재

- 운영체제에서 **멀티태스킹을 위한 프로세스 스케쥴링 방식**을 구현하기 위해 많이 사용됨



### 연산

- `enQueue`: 큐의 뒤쪽(rear 다음)에 요소를 추가
- `deQueue`: 큐의 앞쪽(front)에 있는 요소를 반환한 다음 삭제
- peek: 큐에서 삭제하지 않고 앞에 있는 요소를 반환
- isFull: 큐가 포화상태인지 아닌지를 검사
- isEmpty: 큐가 공백상태인지 아닌지를 검사

```java
enQueue(item)
    if(isFull()) then Queue_Full();
	else {
        rear <- rear + 1;
        Q[rear] <- item;
    }
end enQueue()
    
deQueue()
    if(isEmpty()) then Queue_Empty();
	else {
        front <- front + 1;
        return Q[front];
    }
end deQueue()
```



### 구현

- **배열**을 이용하여 구현하는 방법
- **연결리스트**를 이용하여 구현하는 방법