package org.web.service;

import org.springframework.stereotype.Service;
import org.web.dao.ShowtimeDao;
import org.web.dto.Result;
import org.web.dto.ScreenDto;
import org.web.dto.ShowtimeDto;
import org.web.entity.Screen;
import org.web.entity.Showtimes;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowtimeService {

    private ShowtimeDao showtimeDao;

    public ShowtimeService(ShowtimeDao showtimeDao) {
        this.showtimeDao = showtimeDao;
    }

    // 在 showtime 裡不需要在 set showtimeId => 目的是要給 screen 使用 => showtime 已經擁有id
    // Convert Showtimes entity to ShowtimeDTO
//    private ShowtimeDto convertShowtimeToDTO(Showtimes showtimes){
//        ShowtimeDto dto = new ShowtimeDto();
//        dto.setTime(showtimes.getTime());
//        dto.setDate(showtimes.getDate());
//        dto.setMovieId(showtimes.getMovieId());
//        return dto;
//    }

    // 在 ShowtimeService 製作 ScreenDto (包含 Showtimes 物件)
    // Convert Screen entity to ScreenDTO
    // 由於在 showtime Entity 裡加入 screen Entity 並且 @ManyToOne
//    private ScreenDto convertScreenToDTO(Screen screen){
//        ScreenDto dto = new ScreenDto();
//        dto.setScreenId(screen.getId());
//        dto.setScreenName(screen.getScreenName());
//        dto.setScreenClass(screen.getScreenClass());
//        dto.setTotalRow(screen.getTotalRow());
//        dto.setShowtimes(screen.getShowtimes().stream().map(this::convertShowtimeToDTO).collect(Collectors.toList()));
//        return dto;
//    }

    // 藉由某一影城取得時刻表
    // Retrieve showtimes by theater ID and convert them to DTOs
//    public List<ShowtimeDto> getShowtimesByTheaterId(Integer theaterId){
//        List<Showtimes> showtimes = showtimeDao.findShowtimesByTheaterId(theaterId);
//        return showtimes.stream().map(this::convertShowtimeToDTO).collect(Collectors.toList());
//    }

    public Result createShowtime(Showtimes showtimes){
        showtimeDao.save(showtimes);
        return new Result(200, "success");
    }

    public Result updateShowtime(Showtimes showtimes){
        showtimeDao.save(showtimes);
        return new Result(200, "success");
    }

    public Result deleteShowtime(Integer id){
        showtimeDao.deleteById(id);
        return new Result(200, "success");
    }

    public Result getShowtime(Integer movieId){
        List<Showtimes> list = showtimeDao.findByMovieId(movieId);
        return new Result(200, list);
    }
}
