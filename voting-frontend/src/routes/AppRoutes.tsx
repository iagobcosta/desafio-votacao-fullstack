import { BrowserRouter, Routes, Route } from "react-router-dom";
import { ListAgendasPage } from "../pages/ListAgendasPage";
import { CreateAgendaPage } from "../pages/CreateAgendaPage";
import { AgendaPageDetail } from "../pages/AgendaPageDetail";

export function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/pautas" element={<ListAgendasPage />} />
        <Route path="/pautas/nova" element={<CreateAgendaPage />} />
        <Route path="/pautas/:id" element={<AgendaPageDetail />} />
      </Routes>
    </BrowserRouter>
  );
}