import Sidebar from '../../components/Sidebar';
import Header from '../../components/Header';
import Messages from '../../components/Messages';

const Home = () => {
  return (
    <div className="flex h-screen">
      <Sidebar />
      <main className="flex-grow bg-gray-100">
        <Header />
        <Messages />
      </main>
    </div>
  );
};

export default Home;