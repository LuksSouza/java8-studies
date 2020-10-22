package br.com.studies.java8.customClass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}

public class CustomClass {

	public static void main(String[] args) {
		
		List<Course> courses = List.of(
            new Course("Spring", "Framework", 98, 20000),
			new Course("Spring Boot", "Framework", 95, 18000), 
			new Course("API", "Microservices", 97, 22000),
			new Course("Microservices", "Microservices", 96, 25000),
			new Course("FullStack", "FullStack", 91, 14000), 
			new Course("AWS", "Cloud", 92, 21000),
			new Course("Azure", "Cloud", 99, 21000), 
			new Course("Docker", "Cloud", 92, 20000),
            new Course("Kubernetes", "Cloud", 91, 20000)
		);
		
		Predicate<Course> scoreHigher90 = course -> course.getReviewScore() > 90;
		Predicate<Course> scoreLow95 = course -> course.getReviewScore() < 95;
		Predicate<Course> scoreHigher95 = course -> course.getReviewScore() > 95;

		//if all matches, then return true
		System.out.println(courses.stream()
			.allMatch(scoreHigher90));

		//if none matches, then return true
		System.out.println(courses.stream()
			.noneMatch(scoreLow95));

		//if any matches, then return true
		System.out.println(courses.stream()
			.anyMatch(scoreHigher95));


		Comparator<Course> sortByScore = Comparator.comparingInt(Course::getReviewScore);
		Comparator<Course> sortByScoreReversed = Comparator.comparingInt(Course::getReviewScore).reversed();
		Comparator<Course> sortByScoreAndNoOfStudents = Comparator.comparingInt(Course::getReviewScore)
																  .thenComparingInt(Course::getNoOfStudents);

		System.out.println(courses.stream().sorted(sortByScore).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(sortByScoreReversed).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(sortByScoreAndNoOfStudents).collect(Collectors.toList()));

		//limit, skip, takeWhile and dropWhile
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.limit(3)
						.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.skip(3)
						.collect(Collectors.toList()));

		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.takeWhile(c -> c.getReviewScore() > 95)
						.limit(2)
						.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.dropWhile(c -> c.getReviewScore() > 95)
						.limit(2)
						.collect(Collectors.toList()));

		//max, min, findFirst, findAny
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.max(Comparator.comparingInt(Course::getReviewScore)));
		
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.min(Comparator.comparingInt(Course::getReviewScore)));

		//Optional[Microservices:25000:96]
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.skip(3)
						.findFirst());

		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.skip(3)
						.findAny());

		//single result like sum, avarage, count
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.filter(c -> c.getCategory().equals("Cloud"))
						.mapToInt(Course::getNoOfStudents)
						.sum());

		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.filter(c -> c.getCategory().equals("Cloud"))
						.mapToInt(Course::getNoOfStudents)
						.average());
		
		System.out.println(courses.stream()
						.sorted(sortByScoreReversed)
						.filter(c -> c.getCategory().equals("Cloud"))
						.count());

		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)));
		//{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91], 
		//  FullStack=[FullStack:14000:91], 
		// Microservices=[API:22000:97, Microservices:25000:96],
		// Framework=[Spring:20000:98, Spring Boot:18000:95]}

		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		//{Cloud=4, FullStack=1, Microservices=2, Framework=2}

		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		//{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.mapping(Course::getName, Collectors.toList()))));
		//{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
    }
}