import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useMovies() {
  const { movies } = useContext(AppStateContext);

  return movies;
}
