import { useContext } from "react";
import AppStateContext from "../contexts/AppStateContext";

export default function useTimeShedule() {
  const { timeSchedule } = useContext(AppStateContext);

  return timeSchedule;
}
