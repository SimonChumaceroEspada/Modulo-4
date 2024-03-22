package org.example.memoryallocatiorIvan;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    IMemoryAllocator allocator = new MemoryAllocator(1000, new FirstFitAlgorithm());

    allocator.Allocate("A", 50);
    allocator.Allocate("B", 150);
    allocator.Allocate("C", 250);
    allocator.Allocate("D", 350);

    allocator.ShowMemory();

    allocator.DeAllocate("C");
    allocator.Allocate("E", 60);

    allocator.ShowMemory();

    allocator.DeAllocate("D");
    allocator.ShowMemory();

  }
}

// Aqui solo definimos los metodos que usaremos para la implementacion de la memoria
interface IMemoryAllocator {
  // Allocate memory for an object
  boolean Allocate(String objectName, int size);

  // Deallocate memory for an object
  boolean DeAllocate(String objectName);

  boolean IsEmpty();

  boolean IsFull();

  void ShowMemory();
}

// Aqui definimos el algoritmo de asignacion de memoria
interface IAllocationAlgorithm {
  MemoryBlock GetMemoryBlock(List<MemoryBlock> blocks, int size);
}

class MemoryBlock {
  private int size;
  private String object;

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }


  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public boolean IsFree() {
    return object == null;
  }
}

class MemoryAllocator implements IMemoryAllocator {
  private int totalSize;
  private IAllocationAlgorithm algorithm;

  private List<MemoryBlock> blocks;

  public MemoryAllocator(int totalSize, IAllocationAlgorithm algorithm) {
    this.totalSize = totalSize;
    this.algorithm = algorithm;
    blocks = new ArrayList<MemoryBlock>();

    // Create a single block with the total size, como es el primero y unico bloque ocupa todo el espacio
    MemoryBlock block = new MemoryBlock();
    block.setSize(totalSize);
    blocks.add(block);
  }

  @Override
  public boolean Allocate(String objectName, int size) {
    MemoryBlock block = algorithm.GetMemoryBlock(blocks, size);

    // Why ? if block is null, then we can't allocate memory
    if (block == null) {
      return false;
    }

    MemoryBlock newBlock = new MemoryBlock();
    newBlock.setSize(size);
    newBlock.setObject(objectName);
    int idxBlock = blocks.indexOf(block);
    blocks.add(idxBlock, newBlock);

    block.setSize(block.getSize() - size);

    if (block.getSize() == 0) {
      blocks.remove(block);
    }

    return true;
  }

  @Override
  public boolean DeAllocate(String objectName) {
    MemoryBlock block = SearchByName(objectName);

    if (block == null) {
      return false;
    }

    block.setObject(null);

    return true;
  }

  private MemoryBlock SearchByName(String objectName) {
    for (MemoryBlock b : blocks) {
      if (objectName.equals(b.getObject())) {
        return b;
      }
    }

    return null;
  }

  @Override
  public boolean IsEmpty() {
    return false;
  }

  @Override
  public boolean IsFull() {
    return false;
  }

  @Override
  public void ShowMemory() {
    for (MemoryBlock m : blocks) {
      System.out.println(m.getObject() + " " + m.getSize());
    }

    System.out.println("-----------------------");
  }
}

class FirstFitAlgorithm implements IAllocationAlgorithm {
  @Override
  public MemoryBlock GetMemoryBlock(List<MemoryBlock> blocks, int size) {

    for (MemoryBlock b : blocks) {
      if (b.IsFree() && b.getSize() >= size) {
        return b;
      }
    }

    return null;
  }
}