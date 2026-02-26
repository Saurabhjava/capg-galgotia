package com;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
//		Stream<Integer> s=Stream.of(2,4,3,5);
//		//Predicate<Integer> p=i->i<30;
//		s.filter(i->i<4).map(i->i*i).forEach(num->System.out.println(num));
		
		List<String> names=new ArrayList<String>();
		names.add("Amit");
		names.add("Saurabh");
		names.add("Abhigyan");
		names.add("Naina");
		names.add("Deependra");
		names.add("Aman");
		names.add("Amit");
		names.add("Naina");
		names.add("Deependra");
		
		//List<String> li= names.stream().filter(name->name.startsWith("A")).map(s->s.concat(" Kumar")).collect(Collectors.toList());
		//System.out.println(li);
		Map<String, Long> m=names.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
		System.out.println(m);
	}

}
