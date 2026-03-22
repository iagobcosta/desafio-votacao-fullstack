import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { MainLayout } from "../layouts/MainLayout";
import { Container } from "../components/Container";
import { searchAgendaById } from "../services/agendaService";

export function AgendaPageDetail() {
  const { id } = useParams();
  const [pauta, setPauta] = useState<any>(null);

  useEffect(() => {
    carregarPauta();
  }, []);

  const carregarPauta = async () => {
    const data = await searchAgendaById(Number(id));
    setPauta(data);
  };

  if (!pauta) {
    return (
      <MainLayout>
        <p>Carregando...</p>
      </MainLayout>
    );
  }

  return (
    <MainLayout>
      <Container>
        <h1 className="text-2xl font-bold mb-4">{pauta.titulo}</h1>

        <p className="text-gray-600 mb-6">{pauta.descricao}</p>

        <button className="bg-green-600 text-white px-6 py-3 rounded-lg font-semibold">
          Abrir sessão de votação
        </button>
      </Container>
    </MainLayout>
  );
}