Algorithms and Data Structures 4 — Assignment

This project focuses on implementing graph traversal and shortest path algorithms, specifically Breadth-First Search (BFS) and Dijkstra’s algorithm, using a vertex-centric approach. Instead of relying on separate Edge objects, edge data is embedded directly within the Vertex instances.

Main Components

Vertex.java: Defines a graph vertex that holds its own weighted adjacency list

WeightedGraph.java: Implements the graph structure using the vertex-weighted model

Search.java: Interface for implementing various graph search algorithms

Implemented Algorithms

BreadthFirstSearch.java: Identifies the shortest path in terms of edge count

DepthFirstSearch.java: Traverses each branch deeply before backtracking

DijkstraSearch.java: Computes shortest paths based on edge weights

Highlights

Vertex-Centric Design: The graph is built around vertices and their direct connections, eliminating the need for separate edge objects

Generic Architecture: Supports any type of data

Interchangeable Search Methods: Compatible with multiple traversal strategies through a unified interface