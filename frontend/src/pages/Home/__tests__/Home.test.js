import { render, screen, fireEvent } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import ChatGPTInterface from '../Home';

describe('ChatGPTInterface', () => {
  it('should render the input and title', () => {
    render(
      <MemoryRouter>
        <ChatGPTInterface />
      </MemoryRouter>
    );

    expect(screen.getByText(/enter your message/i)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/type your message/i)).toBeInTheDocument();
  });

  it('should allow user to type in the input', () => {
    render(
      <MemoryRouter>
        <ChatGPTInterface />
      </MemoryRouter>
    );

    const input = screen.getByPlaceholderText(/type your message/i);
    fireEvent.change(input, { target: { value: 'Hello, world!' } });

    expect(input.value).toBe('Hello, world!');
  });

  it('should handle Enter key to send message', () => {
    const mockNavigate = jest.fn();
    jest.mock('react-router-dom', () => ({
      ...jest.requireActual('react-router-dom'),
      useNavigate: () => mockNavigate,
    }));

    render(
      <MemoryRouter>
        <ChatGPTInterface />
      </MemoryRouter>
    );

    const input = screen.getByPlaceholderText(/type your message/i);
    fireEvent.change(input, { target: { value: 'Hello, AI!' } });
    fireEvent.keyDown(input, { key: 'Enter', code: 'Enter' });

    expect(mockNavigate).toHaveBeenCalledWith('/result', expect.anything());
  });
});