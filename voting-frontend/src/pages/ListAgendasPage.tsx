import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


import { listAgendas } from "../services/agendaService";
import { MainLayout } from "../layouts/MainLayout";
import { Container } from "../components/Container";
import type { Agenda } from "../types/agenda";

export function ListAgendasPage() {
  const [pautas, setPautas] = useState<Agenda[]>([]);

  useEffect(() => {
    carregarPautas();
  }, []);

  const carregarPautas = async () => {
    const data = await listAgendas();
    setPautas(data);
  };

  return (
    <MainLayout>
      <Container>
        <h1 className="text-2xl font-bold mb-6">Pautas cadastradas</h1>

        {pautas.length === 0 && (
          <p className="text-gray-500">Nenhuma pauta cadastrada</p>
        )}

        <div className="flex flex-col gap-4">
          {pautas.map((pauta) => (
            <div
              key={pauta.id}
              className="border p-4 rounded-lg hover:shadow-md transition"
            >
              <h2 className="text-lg font-semibold">{pauta.title}</h2>
              <p className="text-gray-600">{pauta.description}</p>
              <Link
                to={`/pautas/${pauta.id}`}
                className="text-blue-600 hover:underline"
              >
                Ver detalhes
              </Link>
            </div>
          ))}
        </div>
      </Container>
    </MainLayout>
  );
}