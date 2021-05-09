# Large Scale Data Processing: Final Project
# Evi Prousanidou, Robert Reiners

## Graph matching
For the final project, you are provided 6 CSV files, each containing an undirected graph, which can be found [here](https://drive.google.com/file/d/1khb-PXodUl82htpyWLMGGNrx-IzC55w8/view?usp=sharing). The files are as follows:  

|           File name           |        Number of edges       |  # of Matching  |  Run time | Machine   
| ------------------------------| ---------------------------- | --------------- | --------- | --------- |                
| com-orkut.ungraph.csv         | 117185083                    |                 |           |           |
| twitter_original_edges.csv    | 63555749                     |                 |           |           |
| soc-LiveJournal1.csv          | 42851237                     |                 |           |           |
| soc-pokec-relationships.csv   | 22301964                     |                 |           |           |
| musae_ENGB_edges.csv          | 35324                        | 1540            |  46       | CPU       |
| log_normal_100.csv            | 2671                         | 49              |   6       | CPU       |


Your goal is to compute a matching as large as possible for each graph. 


## Luby Algorithm

Luby algorithm is used to get the Maximal Independent Set (MIS). By changing the vertices to edges we get the maximal matching of the graph.

Consider the algorithm of this form for G = (V, E):
   1. I = ∅, G' = G <br>
   2. While G' is not the empty graph <br> 
      (a) For the set of active vertices S ⊆ V select each vertex v independently to have a value of 1 with probability Pr(v) and 0 otherwise. Suppose Pr(v) = 1/2d<sub>v</sub> , where dv ≡ degree of v. <br>
      (b) For every vertex in S send value b<sub>v</sub> to neighbors
      (c) Add edge between vertex v where b<sub>v</sub> = 1 and vertex x where b<sub>v</sub> = 0 to matching M<br>
      (d) Send message to neighbors of edge v and u that the edge has been added to the matching M <br>
      (e) Remove v and x and the neighbors of both from G'. <br>

The algorithm terminates in O(log n) rounds with high probability.


## Augmenting Path
A maximum matching M is said to be Maximum if for any other matching M', |M|≥ |M'|

  <u> If matching M is maximum -> M is maximal </u>

So, once we have the maximal matching we can get the maximum matching through the augmenting paths

 Definitioon of Augmenting Path:
 Given a graph, G = (V, E) and a matching M ⊆ E a path P is called an augmenting path for M if:
   1. The two end points of P are unmatched by M
   2. The edges of P alternate between edges ∈ M and edges 6∈ M
  
  
  <u> A matching M is maximum iff it has no augmenting path </u>
  
  

* A project report that includes the following:


  * An estimate of the amount of computation used for each test case. For example, "the program runs for 15 minutes on a 2x4 N1 core CPU in GCP." If you happen to be executing mulitple algorithms on a test case, report the total running time.
  * Description(s) of your approach(es) for obtaining the matchings. It is possible to use different approaches for different cases. Please describe each of them as well as your general strategy if you were to receive a new test case.
  * Discussion about the advantages of your algorithm(s). For example, does it guarantee a constraint on the number of shuffling rounds (say `O(log log n)` rounds)? Does it give you an approximation guarantee on the quality of the matching? If your algorithm has such a guarantee, please provide proofs or scholarly references as to why they hold in your report.




