import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Trains {
    private static final String[] CITIES = {"Moscow", "St.Petersburg", "Ekaterinburg", "Paris", "London"};

    private static final ThreadLocalRandom RNG = ThreadLocalRandom.current();
    private static Date DatatypeConverter;
    private static Objects Trains;

    public static List<Train> findTrainsWithSameDestination(final Collection<Train> trains, final String destination) {
        List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .collect(Collectors.toList());
    }

    public static List<Train> findTrainsWithSameDestinationAndAfterTime(final Collection<Train> trains,
                                                                        final String destination,
                                                                        final String givenTime) {
       List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .filter(train -> DatatypeConverter.getTime(Trains))
                .collect(Collectors.toList());
    }

    public static List<Train> findTrainsWithSameDestinationAndHaveCommonSeats(final Collection<Train> trains,
                                                                              final String destination) {
        List<Train> result = new ArrayList<>(trains);
        return result.stream()
                .filter(train -> Objects.equals(train.getDestination(), destination))
                .filter(train -> train.getSeatCountByCarType(Train.CarType.COMMON) > 0)
                .collect(Collectors.toList());
    }

    public static List<Train> newRandomTrainList(final int trainCount) {
        List<Train> trains = new ArrayList<>(trainCount);

        for (int i = 0; i < trainCount; i++)
            trains.add(newRandomTrain());

        return trains;
    }

    public static Train newRandomTrain() {
        final String city = randomCity();
        final String number = randomNumber();
        final String time = randomTime();

        Train train = new Train(city, number, time, 0, 0, 0, 0);
        for (Train.CarType type : Train.CarType.values())
            train.setSeatCountByCarType(type, RNG.nextInt(21));
        return train;
    }

    private static String randomCity() {
        return CITIES[RNG.nextInt(CITIES.length)];
    }

    private static String randomTime() {
        return String.format("%02d:%02d:%02d", RNG.nextInt(13), RNG.nextInt(60), RNG.nextInt(60));
    }

    private static String randomNumber() {
        return String.format("%03d", RNG.nextInt(1000));
    }
}