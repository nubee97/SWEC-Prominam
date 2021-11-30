import SwiperCore, { Navigation } from "swiper";
import { Swiper, SwiperSlide } from "swiper/react";
import { Link } from "react-router-dom";
import useMovies from "../hooks/useMovies";

// css
import "../css/main.css";
import "../css/select_movies.css";
import "swiper/swiper-bundle.min.css";
import "swiper/swiper.min.css";

SwiperCore.use(Navigation);

export default function SelectMovies(props) {
  const movies = useMovies();

  function addToLocalUrlAndTitle(url, title) {
    localStorage.url = url;
    localStorage.title = title;
    console.log("save to local");
  }

  return (
    <section className="box-office">
      <div className="name">
        <h1>박스오피스</h1>
      </div>
      <div className="swiper-container">
        <Swiper
          modules={Navigation}
          slidesPerView={5}
          spaceBetween={30}
          centeredSlides={true}
          loop={true}
          navigation={true}
        >
          {movies.map((movie) => {
            return (
              <>
                <SwiperSlide className="swiper-slide">
                  <Link to="/cinema">
                    <img
                      src={movie.url}
                      alt={movie.title}
                      style={{ width: "300px", height: "427.5px" }}
                      onClick={() => {
                        addToLocalUrlAndTitle(movie.url, movie.title);
                      }}
                    />
                  </Link>
                </SwiperSlide>
              </>
            );
          })}
        </Swiper>
      </div>
    </section>
  );
}
