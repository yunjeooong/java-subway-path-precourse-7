package subway.repository;

import static net.bytebuddy.agent.builder.AgentBuilder.Default.of;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    static {
        List<Station> initialStations= List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("매봉역"),
                new Station("양재시민의역")

                );
        stations.addAll(initialStations);
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }
}
