import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Train> trainsList = Trains.newRandomTrainList(10);

        System.out.println("Original list:");
        trainsList.forEach(System.out::println);

        List<Train> trainsWithGivenDestination = Trains.findTrainsWithSameDestination(trainsList, "Moscow");
        System.out.println("Trains for Moscow:");
        trainsWithGivenDestination.forEach(System.out::println);

        List<Train> trainsWithGivenDestinationAndTime = Trains
                .findTrainsWithSameDestinationAndAfterTime(trainsList, "Paris", "09:00:00");
        System.out.println("Trains for Paris and 09:00:");
        trainsWithGivenDestinationAndTime.forEach(System.out::println);

        List<Train> trainsWithGivenDestinationAndSeats = Trains
                .findTrainsWithSameDestinationAndHaveCommonSeats(trainsList, "Ekaterinburg");
        System.out.println("Trains for Ekaterinburg and seats:");
        trainsWithGivenDestinationAndSeats.forEach(System.out::println);
    }
}