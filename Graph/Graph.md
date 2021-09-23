# 그래프
## 관계와 그래프
순서쌍으로 표현됨 - (x,y)  

<행렬식 표현>  
1 1 1 ... 0  
0 0 0 ... 1  
| | | ... |  
1 0 1 ... 0  
행렬의 원소 a_ij가 1이라면 i와 j는 관계가 있음. 0이라면 관계가 없음.  

그래프 - G_R = (V,E,r)  
  - V : 정점들의 집합
  - E : 간선들의 집합
  - r : E, V의 원소들 간의 관계  

## 유향/무향 그래프  
  - 유향 간선 : 정점들의 순서쌍 (x,y) != (y,x) 
  - 무향 간선 : 정점들의 쌍 (x,y) = (y,x)  

  - 유향 그래프 : 유향 간선이 있는 그래프
  - 무향 그래프 : 유향 간선이 없는 그래프. 무향 간선 밖에 없는 그래프.

## 용어 정리  
End vertices of an edge : 간선이 연결하는 두 정점  
Edges incident on a vertex : 한 정점에 이어져 있는 간선들  
인접한 정점 : 한 정점에 대해 간선으로 연결 되어있는 정점들  
정점의 차수 : 정점에 연결되어있는 간선의 수  
다중 간선 : 같은 두 정점들을 연결하는 간선들  
Self-loop : 시작점과 끝점이 같은 간선  

경로 : 
  정점과 간선을 거쳐가는 과정  
  정점에서 시작하여 정점에서 끝남   
단순 경로 : 중복되는 간선, 정점을 지나지 않는 경로  
회로 : 시작점과 끝점이 같은 경로  
단순 회로 : 단순 경로인 회로  

## 그래프의 성질
### 표기법
 - n : 정점의 수
 - m : 간선의 수
 - deg(v) : 정점 v의 차수
### 성질1 (악수 정리)
sum(deg(v)) = 2m
### 성질2
Self-loop가 없는 무향 그래프에서,  
m <= n(n-1)/2



# 그래프 모델링
 - 교통망
 - 도로망
 - 배관, 배선 망
 - 통신망

# 그래프 표현
## 그래프에 대한 주요 함수
### Vertices and edges
 - are positions
 - store elements

### Accessor methods 
 - aVertex()
 - incidentEdges(v)
 - endVertices(e)
 - isDirected(e)
 - origin(e) : 유향간선의 시작점
 - destination(e) : 유향간선의 도착점
 - opposite(v,e) : e에 연결되어있는 정점 중 v를 제외한 나머지 정점
 - areAdjacent(v,w)

### Update methods
 - insertVertex(o) o?
 - insertEdge(v,w,o)
 - insertDirectedEdge(v,w,o)
 - removeVertex(v)
 - removeEdge(e)

### Generic methods
 - numVertices()
 - numEdges()
 - vertices()
 - edges()






## 출처
SW Expert Academy - 문제해결 심화 - 그래프
https://swexpertacademy.com/main/learn/course/subjectDetail.do?courseId=AVuPDj5qAAfw5UW6&subjectId=AWWxyoNqAiQDFAW4
