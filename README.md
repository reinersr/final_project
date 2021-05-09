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
The algorithm terminates in O(log n) rounds with high probability.

Consider the algorithm of this form for G = (V, E):
   1. I = ∅, G' = G
   2. While G' is not the empty graph
      (a) Choose a random set of vertices S ⊆ V by selecting each vertex v independently with probability Pr(v). Suppose Pr(v) = 1/d<sub>v</sub> , where dv ≡ degree of v.
      
      (b) For every edge (u, v) ∈ E(G'') if both endpoints are in S, then remove the vertex of lower degree from S (break ties). Denote the set after this step as S''.
      (c) Remove S'' and Neighbor(S') and all adjacent edges from G0.
      (d) I = I U S''


## Augmenting Path

* A project report that includes the following:


  * An estimate of the amount of computation used for each test case. For example, "the program runs for 15 minutes on a 2x4 N1 core CPU in GCP." If you happen to be executing mulitple algorithms on a test case, report the total running time.
  * Description(s) of your approach(es) for obtaining the matchings. It is possible to use different approaches for different cases. Please describe each of them as well as your general strategy if you were to receive a new test case.
  * Discussion about the advantages of your algorithm(s). For example, does it guarantee a constraint on the number of shuffling rounds (say `O(log log n)` rounds)? Does it give you an approximation guarantee on the quality of the matching? If your algorithm has such a guarantee, please provide proofs or scholarly references as to why they hold in your report.




